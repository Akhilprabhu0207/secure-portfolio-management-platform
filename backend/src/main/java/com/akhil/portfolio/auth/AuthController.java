package com.akhil.portfolio.auth;
import com.akhil.portfolio.security.JwtService; import com.akhil.portfolio.user.*; import jakarta.validation.Valid; import jakarta.validation.constraints.*; import org.springframework.http.HttpStatus; import org.springframework.security.authentication.*; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth") public class AuthController {
 private final AuthenticationManager manager; private final JwtService jwt; private final AppUserRepository users; private final PasswordEncoder encoder;
 public AuthController(AuthenticationManager m,JwtService j,AppUserRepository u,PasswordEncoder e){manager=m;jwt=j;users=u;encoder=e;}
 @PostMapping("/register") @ResponseStatus(HttpStatus.CREATED) public void register(@Valid @RequestBody RegisterRequest r){if(users.findByUsername(r.username()).isPresent())throw new IllegalArgumentException("Username already exists");users.save(new AppUser(r.username(),encoder.encode(r.password()),Role.USER));}
 @PostMapping("/login") public Token login(@Valid @RequestBody LoginRequest r){var a=manager.authenticate(new UsernamePasswordAuthenticationToken(r.username(),r.password()));var u=users.findByUsername(a.getName()).orElseThrow();return new Token(jwt.create(u.getUsername()),u.getRole().name());}
 public record RegisterRequest(@NotBlank @Size(max=80)String username,@NotBlank @Size(min=8,max=128)String password){}
 public record LoginRequest(@NotBlank @Size(max=80)String username,@NotBlank @Size(min=8,max=128)String password){}
 public record Token(String token,String role){}
}