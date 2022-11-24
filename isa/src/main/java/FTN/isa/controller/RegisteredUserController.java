package FTN.isa.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FTN.isa.model.Person;
import FTN.isa.model.RegisteredUser;
import FTN.isa.modelDTO.RegisteredUserDTO;
import FTN.isa.service.IRegisteredUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/registeredUser")
public class RegisteredUserController {

	@Autowired
	private IRegisteredUserService _registeredUserService;
	
	@Autowired
    private ModelMapper modelMapper;

    @Autowired
    public RegisteredUserController(IRegisteredUserService registeredUserService) {
        this._registeredUserService = registeredUserService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Register new registered user", description = "Register new registered user", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created regUser",
					content = { @Content(mediaType = "application/json", schema = @Schema(implementation = RegisteredUser.class)) }),
			@ApiResponse(responseCode = "409", description = "Not possible to register new person when given id is not null",
					content = @Content)
	})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisteredUser> saveRegisteredUser(@RequestBody RegisteredUser registeredUser)  {
    	RegisteredUser savedRegisteredUser = null;
        try {
        	savedRegisteredUser = _registeredUserService.saveRegisteredUser(registeredUser);
            return new ResponseEntity<RegisteredUser>(savedRegisteredUser, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<RegisteredUser>(savedRegisteredUser, HttpStatus.CONFLICT);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Boolean editUser(@PathVariable long id, @RequestBody RegisteredUserDTO registeredUserDTO) {
        RegisteredUser userRequest = modelMapper.map(registeredUserDTO, RegisteredUser.class);
    	return _registeredUserService.updateRegisteredUser(id, userRequest);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<RegisteredUser> findById(@RequestParam Long id){
        try {
        	RegisteredUser toReturn = _registeredUserService.findById(id);
            return new ResponseEntity<RegisteredUser>(toReturn, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
