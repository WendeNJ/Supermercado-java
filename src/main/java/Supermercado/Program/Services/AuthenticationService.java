package Supermercado.Program.Services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final JwtService jwtService;

    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    // Recebe Authentication como parâmetro para gerar o token do usuário autenticado
    public String authenticate(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }
}
