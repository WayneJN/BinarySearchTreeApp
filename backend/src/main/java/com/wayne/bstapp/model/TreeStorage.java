package com.wayne.bstapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class TreeStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(length = 1000)
    private String inputNumbers;

    @Setter
    @Column(length = 5000)
    private String treeJson;

    @Setter
    @Column(length = 2000) // ✅ New field for traversal view
    private String traversalJson;

    public TreeStorage() {}

    public TreeStorage(String inputNumbers, String treeJson) {
        this.inputNumbers = inputNumbers;
        this.treeJson = treeJson;
    }
}
