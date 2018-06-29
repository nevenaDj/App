import { Subject } from "./subject";

export class ExaminationPeriod implements ExaminationPeriodInterface {
    public id: number;
    public date: string;
    public subject: Subject;
   	
	constructor(stdCfg: ExaminationPeriodInterface)
	{	
        this.id = stdCfg.id;
        this.date = stdCfg.date;
        this.subject = stdCfg.subject;
	}
}


interface ExaminationPeriodInterface{
    id: number;
    date: string;
    subject: Subject;
}