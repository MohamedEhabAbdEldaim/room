package com.midooabdaim.room.data.local;

//import androidx.room.PrimaryKey;

//@Entity(foreignKeys = @ForeignKey(entity = item.class,
//         parentColumns = "id"
//        , childColumns = "itemId"
//        , onDelete = CASCADE))
class midoo {
    //  @PrimaryKey(autoGenerate = true)
    private int ids;
    private String phone;

    private int itemId;

    public midoo() {
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}