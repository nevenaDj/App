import { Subject } from "./subject";

export class ApplyingExam implements ApplyingExamInterface {
    public id: number;
    public flag: boolean;
    public subject: Subject;
   	
	constructor(stdCfg: ApplyingExam)
	{	
        this.id = stdCfg.id;
        this.flag = stdCfg.flag;
        this.subject = stdCfg.subject;
	}
}


interface ApplyingExamInterface{
    id: number;
    flag: boolean;
    subject : Subject;
}