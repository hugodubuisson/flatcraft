package fr.univartois.butinfo.r304.flatcraft.model.dimension;

import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.SpriteStore;
import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.etat.PresqueCasse;
import fr.univartois.butinfo.r304.flatcraft.model.map.Case;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.model.resources.etat.InInventarie;

import java.util.Random;

public class CaseFactory implements CellFactory{
	private static final Random RANDOM = new Random();
	private ISpriteStore spriteStore;
    private static final CaseFactory INSTANCE = new CaseFactory(SpriteStore.getInstance());

    private CaseFactory(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    public static CaseFactory getInstance() {
        return INSTANCE;
    }
    
    @Override
	public void setSpriteStore(ISpriteStore spriteStore) {
		this.spriteStore = spriteStore;	
	}

    @Override
    public Cell createSky(int y, int i) {  
        if (y < 11 && i != 0 && i != 40 && y > 1 && i!=79) { 
        	//pas de nuage sur les bords et pas de nuage trop proche du sol
            int n = RANDOM.nextInt(10);
        	if (n < 1) {
        		return new Case(spriteStore.getSprite("default_cloud"));
            } else {
            	return new Case(spriteStore.getSprite("default_ice"));
            }
        } else {
        	return new Case(spriteStore.getSprite("default_ice"));
        }
    }

	@Override
	public Cell createSoilSurface() {
		return new Case(new Resource("dirt",new InInventarie(spriteStore.getSprite("default_grass"),null),null,new PresqueCasse()));
	}

	@Override
	public Cell createSubSoil() {
        int n = RANDOM.nextInt(200);
        if (n < 190) {
        	return new Case(new Resource("cobble",new InInventarie(spriteStore.getSprite("default_cobble"),null),null,new PresqueCasse()));
        } else if (n == 190) {
        	return new Case(new Resource("mineral_diamond",new InInventarie(spriteStore.getSprite("default_mineral_diamond"),null),null,new PresqueCasse()));
        } else if (n == 191){
        	return new Case(new Resource("mineral_gold",new InInventarie(spriteStore.getSprite("default_mineral_gold"),null),null,new PresqueCasse()));
        } else if (n == 192){
        	return new Case(new Resource("mineral_copper",new InInventarie(spriteStore.getSprite("default_mineral_copper"),null),null,new PresqueCasse()));
        } else if (n == 193){
        	return new Case(new Resource("mineral_mese",new InInventarie(spriteStore.getSprite("default_mineral_mese"),null),null,new PresqueCasse()));
        } else if (n == 194){
        	return new Case(new Resource("mineral_coal",new InInventarie(spriteStore.getSprite("default_mineral_coal"),null),null,new PresqueCasse()));
        } else if (n == 195){
        	return new Case(new Resource("mineral_iron",new InInventarie(spriteStore.getSprite("default_mineral_iron"),null),null,new PresqueCasse()));
        } else if (n == 196){
        	return new Case(new Resource("gravel",new InInventarie(spriteStore.getSprite("default_gravel"),null),null,new PresqueCasse()));
        } else {
        	return new Case(new Resource("cobble",new InInventarie(spriteStore.getSprite("default_cobble"),null),null,new PresqueCasse()));
        }
	}

	@Override
	public Cell createTrunk() {
		return new Case(new Resource("acacia_tree",new InInventarie(spriteStore.getSprite("default_acacia_tree"),null),null,new PresqueCasse()));
	}

	@Override
	public Cell createLeaves() {
		return new Case(new Resource("acacia_leave",new InInventarie(spriteStore.getSprite("default_acacia_leaves"),null),null,new PresqueCasse()));
	}

}
