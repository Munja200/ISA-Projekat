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

    public constructor(id: any,
        name: any,
        surname: any,
        email: any,
        password: any,
        phonNumber: any,
        jmbg: any,
        gender: any,
        role: any,
        dateOfBirth: any,
        occupation: any,
        informationAboutCompany: any,
        bloodType: any,
        address: any
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