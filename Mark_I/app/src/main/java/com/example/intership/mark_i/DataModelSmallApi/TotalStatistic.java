package com.example.intership.mark_i.DataModelSmallApi;

public class TotalStatistic {
    String id;
    String person_addby;
    String person_name;
    String person_rank;
    String site_addby;
    String site_id;

    public String getPerson_addby() {
        return person_addby;
    }

    public void setPerson_addby(String person_addby) {
        this.person_addby = person_addby;
    }

    String site_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_rank() {
        return person_rank;
    }

    public void setPerson_rank(String person_rank) {
        this.person_rank = person_rank;
    }

    public String getSite_addby() {
        return site_addby;
    }

    public void setSite_addby(String site_addby) {
        this.site_addby = site_addby;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }
}
