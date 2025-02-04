package fr.raksrinana.editsign.fabric.common.wrapper;

import fr.raksrinana.editsign.common.wrapper.IHand;
import fr.raksrinana.editsign.common.wrapper.IItemStack;
import fr.raksrinana.editsign.common.wrapper.IPlayer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public class PlayerWrapper implements IPlayer{
	@NotNull
	@Getter
	private final Player raw;
	
	@Override
	public boolean mayBuild(){
		return raw.mayBuild();
	}
	
	@Override
	@NotNull
	public  IItemStack getHandItem(@NotNull IHand hand){
		var item = raw.getItemInHand((InteractionHand) hand.getRaw());
		return new ItemStackWrapper(item);
	}
}
