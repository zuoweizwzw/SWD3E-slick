package swd.script

class SWDShell {

	GroovyShell shell;
	public void execute(SWDScript script)
	{
		for(String s:script.scripts)
		{
			shell.evaluate(s);
		}
	}
	
	public SWDShell()
	{
		shell=new GroovyShell();
	}
	public void setVariable(String s,Object o)
	{
		shell.setVariable(s, o);
	}
}
