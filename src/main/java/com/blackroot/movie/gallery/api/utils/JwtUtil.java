package com.blackroot.movie.gallery.api.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.blackroot.movie.gallery.api.entity.Rol;
import com.blackroot.movie.gallery.api.entity.Usuario;
import com.blackroot.movie.gallery.api.repository.UserRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

	private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);

	@Autowired
	private UserRepository userRepository;

	private static String PREFIX = "Bearer ";

	private final static String secret = "mySecret";

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, username);
	}

	private String createToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 20))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		log.info(username);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public Rol validateToken(String token) {
		String username = "";

		//username = extractUsername(token);
		//log.info(username);
		
		String jwtToken = token.replace(PREFIX, "");
		//log.info(jwtToken);
		username = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken).getBody().getSubject();

		try {
			Usuario user = userRepository.findByEmail(username.toString());
			log.info(user.toString());
			return user.getRol();
		} catch (Exception e) {

			log.error("Problemas con encontrar el usuario ", e);
			return null;
		}

	}

	public static Claims validateToken2(String token) {
		try {
			log.info(token.toString());
			String jwtToken = token.replace(PREFIX, "");
			log.info(jwtToken);
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(jwtToken).getBody();
		} catch (UnsupportedJwtException | MalformedJwtException ex) {
			throw new BadJWTException("Error en el formato del JWT!");
		} catch (SignatureException exception) {
			throw new BadJWTException("JWT inválido!");
		} catch (ExpiredJwtException ex) {
			throw new ExpiredJWTException();
		}
	}

}
