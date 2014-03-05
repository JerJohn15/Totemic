/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [Jan 22, 2014, 5:03:09 PM (GMT)]
 */
package vazkii.botania.api.mana;

/**
 * Any TileEntity that implements this is considered a Mana Pool,
 * by which nearby functional flowers will pull mana from it.<br>
 * Mana Distributors will also accept it as valid output.<br><br>
 * 
 * <b>Implementation Instructions:</b><br>
 * - Override invalidate() and onChunkUnload(), calling <i>ManaNetworkEvent.removePool(this);</i> on both.<br>
 * - On the first tick of onUpdate(), call <i>ManaNetworkEvent.addPool(this);</i>
 */
public interface IManaPool extends IManaReceiver {

}