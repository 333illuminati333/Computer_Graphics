package sample;

import java.awt.Container;
import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.javafx.geom.Shape;
import javax.vecmath.*;

public class XMassBall {
    public static Sphere getSphere(float radius, String picture, Color3f emissiveColor) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Sphere(radius, primflags, getXMassBallsAppearence(picture,
                emissiveColor));
    }

    public static Sphere getEllipsoid(float radius, String picture, Color3f emissiveColor) {
        int primflags = Primitive.GENERATE_NORMALS;
        return new Sphere(radius, primflags, getXMassBallsAppearence(picture,
                emissiveColor));
    }


    private static Appearance getXMassBallsAppearence(String picture, Color3f emissive) {
        Appearance ap = new Appearance();
        Color3f ambient = new Color3f(0.2f, 0.15f, .15f);
        Color3f diffuse = new Color3f(1.2f, 1.15f, .15f);
        Color3f specular = new Color3f(0.0f, 0.0f, 0.0f);
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        if (picture != "") {

            TextureLoader loader = new TextureLoader(picture, "LUMINANCE", new
                    Container());
            Texture texture = loader.getTexture();

            texture.setBoundaryModeS(Texture.WRAP);
            texture.setBoundaryModeT(Texture.WRAP);
            texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));
            TextureAttributes texAttr = new TextureAttributes();
            texAttr.setTextureMode(TextureAttributes.MODULATE);
            ap.setTexture(texture);
            ap.setTextureAttributes(texAttr);
        }
        return ap;
    }
}