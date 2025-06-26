package com.example.projeto.service;

import com.example.projeto.dto.LoginRequest;
import com.example.projeto.dto.RegisterRequest;
import com.example.projeto.model.Usuario;
import com.example.projeto.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthService authService;

    private Usuario usuario;
    private RegisterRequest registerRequest;
    private LoginRequest loginRequest;

    @BeforeEach
    void setUp() {
        usuario = Usuario.builder()
                .id(1L)
                .username("testuser")
                .email("test@example.com")
                .password("encodedPassword")
                .roles(Set.of("ROLE_USER"))
                .ativo(true)
                .build();

        registerRequest = new RegisterRequest("testuser", "test@example.com", "password123");
        loginRequest = new LoginRequest("testuser", "password123");
    }

    @Test
    void register_ShouldCreateNewUser_WhenValidRequest() {
        // Arrange
        when(usuarioRepository.existsByUsername(registerRequest.getUsername())).thenReturn(false);
        when(usuarioRepository.existsByEmail(registerRequest.getEmail())).thenReturn(false);
        when(passwordEncoder.encode(registerRequest.getPassword())).thenReturn("encodedPassword");
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
        when(usuarioRepository.findByUsername(usuario.getUsername())).thenReturn(Optional.of(usuario));
        when(jwtService.generateToken(any())).thenReturn("jwtToken");

        // Act
        var result = authService.register(registerRequest);

        // Assert
        assertNotNull(result);
        assertEquals("jwtToken", result.getToken());
        assertEquals(usuario.getUsername(), result.getUsername());
        assertEquals(usuario.getEmail(), result.getEmail());
        verify(usuarioRepository).save(any(Usuario.class));
    }

    @Test
    void register_ShouldThrowException_WhenUsernameExists() {
        // Arrange
        when(usuarioRepository.existsByUsername(registerRequest.getUsername())).thenReturn(true);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> authService.register(registerRequest));
        verify(usuarioRepository, never()).save(any());
    }

    @Test
    void register_ShouldThrowException_WhenEmailExists() {
        // Arrange
        when(usuarioRepository.existsByUsername(registerRequest.getUsername())).thenReturn(false);
        when(usuarioRepository.existsByEmail(registerRequest.getEmail())).thenReturn(true);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> authService.register(registerRequest));
        verify(usuarioRepository, never()).save(any());
    }

    @Test
    void login_ShouldReturnToken_WhenValidCredentials() {
        // Arrange
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(null);
        when(usuarioRepository.findByUsername(loginRequest.getUsername()))
                .thenReturn(Optional.of(usuario));
        when(jwtService.generateToken(any())).thenReturn("jwtToken");

        // Act
        var result = authService.login(loginRequest);

        // Assert
        assertNotNull(result);
        assertEquals("jwtToken", result.getToken());
        assertEquals(usuario.getUsername(), result.getUsername());
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
    }

    @Test
    void login_ShouldThrowException_WhenUserNotFound() {
        // Arrange
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(null);
        when(usuarioRepository.findByUsername(loginRequest.getUsername()))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> authService.login(loginRequest));
    }
} 