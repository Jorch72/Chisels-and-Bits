
package mod.chiselsandbits.render.ItemBlockBit;

import java.util.HashMap;

import mod.chiselsandbits.items.ItemChisel;
import mod.chiselsandbits.render.BaseSmartModel;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ISmartItemModel;

@SuppressWarnings( "deprecation" )
public class BitItemSmartModel extends BaseSmartModel implements ISmartItemModel
{
	private final HashMap<Integer, BitItemBaked> modelCache = new HashMap<Integer, BitItemBaked>();

	private IBakedModel getCachedModel(
			final int stateID )
	{
		BitItemBaked out = modelCache.get( stateID );

		if ( out == null )
		{
			out = new BitItemBaked( stateID );
			modelCache.put( stateID, out );
		}

		return out;
	}

	@Override
	public IBakedModel handleItemState(
			final ItemStack stack )
	{
		return getCachedModel( ItemChisel.getStackState( stack ) );
	}
}
