//package me.imrandoet.superheroesaddon.common.items.renderers;
//
//import me.imrandoet.superheroesaddon.SuperheroesAddon;
//import me.imrandoet.superheroesaddon.models.ModelBattleStaff;
//import net.minecraft.client.Minecraft;
//import net.minecraft.entity.Entity;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.client.IItemRenderer;
//import org.lwjgl.opengl.GL11;
//
///**
// * Created by ImranDoet on 21-6-2017.
// */
//public class RenderBattlestaff implements IItemRenderer  {
//
//    protected ModelBattleStaff model;
//
//    public RenderBattlestaff() {
//        model = new ModelBattleStaff();
//    }
//
//    @Override
//    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
//        switch (type) {
//            case EQUIPPED: return true;
//            case EQUIPPED_FIRST_PERSON: return true;
//            default: return false;
//        }
//    }
//
//    @Override
//    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
//        return false;
//    }
//
//    @Override
//    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
//        switch (type) {
//            case EQUIPPED: {
//                GL11.glPushMatrix();
//                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(SuperheroesAddon.MODID, "textures/items/battlestaff_texture.png"));
////                GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
////                GL11.glRotatef(180.0F, 1.0F, 0.0F, 3.0F);
////
////                GL11.glTranslatef(-0.6F, 0.5F, 0.0F);
//                GL11.glTranslatef(0.5F, 0.5F, 0.1F);
////                GL11.glScalef(0.3F, 0.3F, 0.3F);
//                GL11.glRotatef(190.0F, 0.0F, 0.0F, 1.0F);
//                GL11.glRotatef(100.0F, 0.0F, 1.0F, 0.0F);
//                GL11.glRotatef(-5.0F, 1.0F, 0.0F, 0.0F);
//                model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
//                GL11.glPopMatrix();
//            }
//
//            case EQUIPPED_FIRST_PERSON: {
//
//            }
//
//            default: break;
//        }
//    }
//}
