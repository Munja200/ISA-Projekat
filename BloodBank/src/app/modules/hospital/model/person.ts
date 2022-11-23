import { AnyCatcher } from "rxjs/internal/AnyCatcher";
import { Address } from "./address";
import { Role } from "./role";

export class Person {
    id: number;
    name: string ;
    surname: string;
    email: string ;
    password: string ;
    phonNumber: string;
    jmbg: string ;
    gender: string ;
    role: Role ;
    dateOfBirth: Date ;
    occupation: string;
    informationAboutCompany: string ;
    bloodType: string ;
    address: Address;

    public constructor(
        id: number = 0,
        name: string = "",
        surname: string = "",
        email: string = "",
        password: string = "",
        phonNumber: string = "",
        jmbg: string = "",
        gender: string = "",
        role: Role = 0,
        dateOfBirth: Date = new Date(),
        occupation: string = "",
        informationAboutCompany: string = "",
        bloodType: string = "",
        address: Address = new Address()
    ) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.address = address;        
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phonNumber = phonNumber;
        this.jmbg = jmbg;
        this.gender = gender;
        this.role = role;
        this.occupation = occupation;
        this.informationAboutCompany = informationAboutCompany;
        this.bloodType = bloodType;
    }
}