export class Departman implements DepartmanInterface {
    public id: number;
    public name: string;
   	
	constructor(stdCfg: DepartmanInterface)
	{	
        this.id = stdCfg.id;
        this.name = stdCfg.name;       
	}
}


interface DepartmanInterface{
    id: number;
    name: string;
}