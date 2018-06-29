export class Subject implements SubjectInterface {
    public id: number;
    public name: string;
   	
	constructor(stdCfg: SubjectInterface)
	{	
        this.id = stdCfg.id;
        this.name = stdCfg.name;       
	}
}


interface SubjectInterface{
    id: number;
    name: string;
}