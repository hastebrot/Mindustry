package io.anuke.mindustry.ui;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.utils.Align;

import io.anuke.ucore.core.Inputs;
import io.anuke.ucore.scene.ui.Dialog;

public class FloatingDialog extends Dialog{
	
	public FloatingDialog(String title){
		super(title, "dialog");
		setFillParent(true);
		title().setAlignment(Align.center);
		getTitleTable().row();
		getTitleTable().addImage("white", Colors.get("accent"))
		.growX().height(3f).pad(4f);
	}
	
	@Override
	public void addCloseButton(){
		buttons().addImageTextButton("Back", "icon-arrow-left", 30f, this::hide).size(230f, 64f);
		
		keyDown(key->{
			if(key == Keys.ESCAPE || key == Keys.BACK)
				hide();
		});

		update(() -> {
			if(Inputs.keyTap("menu")){
				hide();
			}
		});
	}
}
