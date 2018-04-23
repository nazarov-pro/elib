package org.nazarov.shaheen.elib.mybatis.domain;

/**
 * Created by Shahin on 5/18/2017.
 */
public class Counter {

    private int id;
    private int download;
    private int view;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
