import { Address } from "./address";
import { Person } from "./person";

export class RegisteredUserUpdateDTO {
    id: number = 0;
    name: string;
    surname: string;
    phonNumber: string;
    jmbg: string;
    gender: string;
    occupation: string;
    informationAboutCompany: string;
    dateOfBirth: Date;
    bloodType: string;
    address: Address;
    password: string;

    public constructor(id: any, name: any, surname: any, phonNumber: any, jmbg: any, gender: any, occupation: any,informationAboutCompany: any, 
        dateOfBirth: any, bloodType: any, address: any, password: any) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phonNumber = phonNumber;
        this.jmbg = jmbg;
        this.gender = gender;
        this.occupation = occupation;
        this.informationAboutCompany = informationAboutCompany;
        this.dateOfBirth = dateOfBirth;
        this.bloodType = bloodType;
        this.address = address;
        this.password = password;
    }
}