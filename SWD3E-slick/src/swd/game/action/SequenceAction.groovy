package swd.game.action

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

class SequenceAction extends Action{

	public ArrayList<Action> actions=new ArrayList<Action>();
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		
		if(this.status==0) this.status=1;
		if(actions.size()>0)
		{
			if(actions.get(0).status==2) 
			{
				for(int i=0;i<actions.get(0).listeners.size();i++)
				{
					ActionListener listener=actions.get(0).listeners.get(i);
					listener.onend(actions.get(0));	
				}
				actions.remove(0);
				if(actions.size()>0)
				{
//					actions.get(0).status=1;
				}
				else
				{
					this.status=2;
					return;
				}
			}
			else if(actions.get(0).status==0)
			{
				for(int i=0;i<actions.get(0).listeners.size();i++)
				{
					ActionListener listener=actions.get(0).listeners.get(i);
					listener.onstart(actions.get(0));	
				}
			}
			
			actions.get(0).act(container, game,delta);
		}
		else this.status=2;
	}
	
	public void addAction(Action action)
	{
		this.actions.add(action);
	}
	
	public Action getAction(int i)
	{
		return this.actions.get(i);
	}
	
	public void addActions(Action...actions)
	{
		this.actions.addAll(actions);
	}
	
	public void startAction(Action action)
	{
		this.actions.clear();
		this.actions.add(action);
		this.status==0;
	}

}
