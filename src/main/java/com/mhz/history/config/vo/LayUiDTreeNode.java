package com.mhz.history.config.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class LayUiDTreeNode {
    @Id
    private String id;

    private String title;

    private String parentId;


    @Transient
    private List<LayUiDTreeNode> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<LayUiDTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<LayUiDTreeNode> children) {
        this.children = children;
    }
}
