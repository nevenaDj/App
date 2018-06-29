export class Student implements StudentInterface {
    public id: number;
    public firstName: string;
    public lastName: string;
    public idx: string;
   	
	constructor(stdCfg: StudentInterface)
	{	
        this.id = stdCfg.id;
        this.firstName = stdCfg.firstName;
        this.lastName = stdCfg.lastName;
        this.idx = stdCfg.idx;        
	}
}


interface StudentInterface{
    id: number;
    firstName: string;
    lastName: string;
    idx: string;
}