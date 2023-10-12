package com.digis01.ARoblesTestProgramacionNCapasWeb.RestController;

import com.digis01.ARoblesTestProgramacionNCapasWeb.DAO.UsuarioDAOImplementation;
import com.digis01.ARoblesTestProgramacionNCapasWeb.JPA.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarioApi")
public class UsuarioRestController {

    private UsuarioDAOImplementation usuarioDAOImplementation;

    @Autowired
    public UsuarioRestController(UsuarioDAOImplementation usuarioDAOImplementation) {
        this.usuarioDAOImplementation = usuarioDAOImplementation;
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(new Usuario("", "", ""));
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PostMapping("/Add")
    public ResponseEntity<Integer> Add(@RequestBody Usuario usuario) {
        int usuarioAgregadoId = usuarioDAOImplementation.Add(usuario);
        if (usuarioAgregadoId > 0) {
            return new ResponseEntity<>(usuarioAgregadoId, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable int id) {
        Usuario usuario = usuarioDAOImplementation.GetById(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        Usuario usuario = usuarioDAOImplementation.GetById(id);
        if (usuario != null) {
            usuarioDAOImplementation.Delete(usuario);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
