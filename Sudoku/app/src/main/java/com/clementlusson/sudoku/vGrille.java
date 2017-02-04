package com.clementlusson.sudoku;

import android.os.Parcel;
import android.os.Parcelable;

public class vGrille implements Parcelable {
    int level;
    int num;
    int done;

    public vGrille (){

    }
    public vGrille(int level, int num, int done){
        this.level = level;
        this.num = num;
        this.done = done;
    }
    @Override
    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeInt(num);
        dest.writeInt(level);
        dest.writeInt(done);
    }

    public static final Parcelable.Creator<vGrille> CREATOR = new Parcelable.Creator<vGrille>()
    {
        @Override
        public vGrille createFromParcel(Parcel source)
        {
            return new vGrille(source);
        }

        @Override
        public vGrille[] newArray(int size)
        {
            return new vGrille[size];
        }
    };

    public vGrille(Parcel in) {
        this.num = in.readInt();
        this.level = in.readInt();
        this.done = in.readInt();
    }
}