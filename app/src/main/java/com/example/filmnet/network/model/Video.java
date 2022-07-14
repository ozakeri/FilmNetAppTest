
package com.example.filmnet.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


import com.google.gson.annotations.SerializedName;


public class Video implements Parcelable {

    @SerializedName("status")
    public String status;
    @SerializedName("title")
    public String title;
    @SerializedName("page_title")
    public String pageTitle;
    @SerializedName("slug")
    public String slug;
    @SerializedName("summary")
    public String summary;
    @SerializedName("rate")
    public Float rate;
    @SerializedName("cover_image")
    public CoverImage coverImage;
    @SerializedName("poster_image")
    public PosterImage posterImage;
    @SerializedName("alter_cover_image")
    public AlterCoverImage alterCoverImage;
    @SerializedName("type")
    public String type;
    @SerializedName("flag")
    public String flag;
    @SerializedName("conditional_flag")
    public String conditionalFlag;
    @SerializedName("age_restriction")
    public String ageRestriction;
    @SerializedName("year")
    public Integer year;
    @SerializedName("imdb_rank_percent")
    public Integer imdbRankPercent;
    @SerializedName("original_name")
    public String originalName;
    @SerializedName("duration")
    public String duration;
    @SerializedName("categories")
    public List<Category> categories = null;
    @SerializedName("id")
    public String id;
    @SerializedName("short_id")
    public String shortId;
    @SerializedName("logo_image")
    public LogoImage logoImage;

    protected Video(Parcel in) {
        status = in.readString();
        title = in.readString();
        pageTitle = in.readString();
        slug = in.readString();
        summary = in.readString();
        if (in.readByte() == 0) {
            rate = null;
        } else {
            rate = in.readFloat();
        }
        type = in.readString();
        flag = in.readString();
        conditionalFlag = in.readString();
        ageRestriction = in.readString();
        if (in.readByte() == 0) {
            year = null;
        } else {
            year = in.readInt();
        }
        if (in.readByte() == 0) {
            imdbRankPercent = null;
        } else {
            imdbRankPercent = in.readInt();
        }
        originalName = in.readString();
        duration = in.readString();
        id = in.readString();
        shortId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(title);
        dest.writeString(pageTitle);
        dest.writeString(slug);
        dest.writeString(summary);
        if (rate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(rate);
        }
        dest.writeString(type);
        dest.writeString(flag);
        dest.writeString(conditionalFlag);
        dest.writeString(ageRestriction);
        if (year == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(year);
        }
        if (imdbRankPercent == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imdbRankPercent);
        }
        dest.writeString(originalName);
        dest.writeString(duration);
        dest.writeString(id);
        dest.writeString(shortId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public CoverImage getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(CoverImage coverImage) {
        this.coverImage = coverImage;
    }

    public PosterImage getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(PosterImage posterImage) {
        this.posterImage = posterImage;
    }

    public AlterCoverImage getAlterCoverImage() {
        return alterCoverImage;
    }

    public void setAlterCoverImage(AlterCoverImage alterCoverImage) {
        this.alterCoverImage = alterCoverImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getConditionalFlag() {
        return conditionalFlag;
    }

    public void setConditionalFlag(String conditionalFlag) {
        this.conditionalFlag = conditionalFlag;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getImdbRankPercent() {
        return imdbRankPercent;
    }

    public void setImdbRankPercent(Integer imdbRankPercent) {
        this.imdbRankPercent = imdbRankPercent;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortId() {
        return shortId;
    }

    public void setShortId(String shortId) {
        this.shortId = shortId;
    }

    public LogoImage getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(LogoImage logoImage) {
        this.logoImage = logoImage;
    }
}
