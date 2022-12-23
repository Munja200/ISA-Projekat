export class AppointmentDTO{
    id: number;
    text: string;
    start: Date;
    end: Date;

    public constructor(
        id: number = 0,
        text: string = '',
        start: Date = new Date(),
        end: Date = new Date(),
    ) {
        this.id = id;
        this.text = text;
        this.start = start;
        this.end = end;
    }
}