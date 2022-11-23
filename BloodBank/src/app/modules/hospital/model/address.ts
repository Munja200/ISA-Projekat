export class Address {
    id: number;
    deleted: boolean;
    latitude: number;
    longitude: number;
    street: string;
    number: string;
    city: string;
    country: string;

    public constructor(
        id: number = 0,
        deleted: boolean = false,
        latitude: number = 0,
        longitude: number = 0,
        street: string = "",
        number: string = "",
        city: string = "",
        country: string = "",
    ) {
        this.id = id;
        this.deleted = deleted;
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.number = number;
        this.city = city;
        this.country = country;
    }
}