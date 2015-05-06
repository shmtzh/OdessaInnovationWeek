package com.mycompany.oiw.Description;

import com.mycompany.oiw.R;

/**
 * Created by Sony on 4/24/2015.
 */
public class Description {

    int id;
    int image;
    int description;
    int program;

    public Description(int id) {
        switch (id)
        {   case 1: image= R.drawable.wc_l; description=R.string.show_map;program=R.string.frontend; break;
            case 2: image=R.drawable.wc_l; description=R.string.show_map; program=R.string.backend;  break;
            case 3:image=R.drawable.wc_l; description=R.string.show_map; program=R.string.design; break;
            case 4:image=R.drawable.wc_l; description=R.string.show_map; program=R.string.pm; break;
            case 5:image=R.drawable.hl_l; description=R.string.show_map; program=R.string.hardware; break;
            case 6:image=R.drawable.robotics_l; description=R.string.show_map; program=R.string.robotics; break;
            case 7:image=R.drawable.sl_l; description=R.string.show_map; program=R.string.outsource; break;
            case 8:image=R.drawable.sl_l; description=R.string.show_map; program=R.string.product; break;
            case 9:image=R.drawable.bizdev_l; description=R.string.show_map; program=R.string.bizdev; break;
            case 10:image=R.drawable.sul_l; description=R.string.show_map; program=R.string.sul; break;
            case 11:image=R.drawable.su_l; description=R.string.show_map; program=R.string.su; break;}


    }



    public int getId() {return id;}
    public int getImage() {return image;}
    public int getDescription() {return description;}
    public int getProgram() {return program;}

    public void setId (int id) {this.id=id;}
    public void setImage (int image) {this.image=image;}
    public void setDescription (int description) {this.description=description;}
    public void setProgram (int program) {this.program=program;}








}
