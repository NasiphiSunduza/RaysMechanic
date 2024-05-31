package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Image {
    @Id
    private long imageID;
    private  String imageName;
    @Lob
    private  byte[] imageData;

    protected Image() {
    }

    private Image(imageBuilder imageBuilder) {
        this.imageName = imageBuilder.imageName;
        this.imageData = imageBuilder.imageData;
        this.imageID = imageBuilder.imageID;
    }
    public long getImageID() {
        return imageID;
    }

    public String getImageName() {
        return imageName;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public static class imageBuilder{
        private  String imageName;
        private  byte[] imageData;

        private long imageID;

        public imageBuilder() {
        }

        public imageBuilder setImageName(String imageName) {
            this.imageName = imageName;
            return this;
        }

        public imageBuilder setImageData(byte[] imageData) {
            this.imageData = imageData;
            return this;
        }

        public imageBuilder setImageID(long imageID) {
            this.imageID = imageID;
            return this;
        }


        public imageBuilder copy(String imageName, byte[] imageData, long imageID) {
            this.imageName = imageName;
            this.imageData = imageData;
            this.imageID = imageID;

            return  this;
        }

        public Image build(){
            return new Image(this);
        }
    }



}
