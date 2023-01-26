export class AppointmentDTO {
    id: number;
    text: string;
    start: Date;
	end: Date;
    centerName: String;

    public constructor(
        id: number = 0, 
        text: string='',
        start: Date, 
        end: Date,
        centerName:string
    ) {
        this.id = id;
        this.text = text;
        this.start = start;
        this.end = end;
        this.centerName = centerName;
    }
}