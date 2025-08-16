package com.wayne.bstapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wayne.bstapp.model.InputWrapper;
import com.wayne.bstapp.model.TreeStorage;
import com.wayne.bstapp.repository.TreeRepository;
import com.wayne.bstapp.service.BinarySearchTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/bst")
public class BSTController {

    @Autowired
    private TreeRepository treeRepo;

    @PostMapping("/process-numbers")
    public TreeStorage processNumbers(@RequestBody InputWrapper inputWrapper) throws JsonProcessingException {
        List<Integer> numbers = inputWrapper.getNumbers();
        BinarySearchTree bst = new BinarySearchTree();

        numbers.forEach(bst::insert);

        TreeStorage tree = new TreeStorage();
        tree.setInputNumbers(numbers.toString());

        ObjectMapper mapper = new ObjectMapper();
        tree.setTreeJson(mapper.writeValueAsString(bst.getRoot()));
        tree.setTraversalJson(mapper.writeValueAsString(bst.inOrderTraversal()));

        return treeRepo.save(tree);
    }

    @PostMapping("/process-balanced")
    public TreeStorage processBalanced(@RequestBody InputWrapper inputWrapper) throws JsonProcessingException {
        List<Integer> numbers = inputWrapper.getNumbers();
        Collections.sort(numbers);
        BinarySearchTree bst = new BinarySearchTree();

        bst.buildBalancedTree(numbers);

        TreeStorage tree = new TreeStorage();
        tree.setInputNumbers(numbers.toString());

        ObjectMapper mapper = new ObjectMapper();
        tree.setTreeJson(mapper.writeValueAsString(bst.getRoot()));
        tree.setTraversalJson(mapper.writeValueAsString(bst.inOrderTraversal()));

        return treeRepo.save(tree);
    }

    @GetMapping("/previous-trees")
    public List<TreeStorage> getPreviousTrees() {
        return treeRepo.findAll();
    }
}
