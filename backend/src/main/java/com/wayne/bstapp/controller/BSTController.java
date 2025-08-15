package com.wayne.bstapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wayne.bstapp.model.TreeStorage;
import com.wayne.bstapp.repository.TreeRepository;
import com.wayne.bstapp.service.BinarySearchTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // Enables CORS for frontend access
@RestController
@RequestMapping("/api/bst")
public class BSTController {

    private final BinarySearchTree bst = new BinarySearchTree(); // ✅ Single shared instance

    @Autowired
    private TreeRepository treeRepo;

    @PostMapping("/insert")
    public String insert(@RequestParam int value) {
        bst.insert(value);
        return "Inserted " + value;
    }

    @GetMapping("/search")
    public boolean search(@RequestParam int value) {
        return bst.search(value);
    }

    @GetMapping("/inorder")
    public List<Integer> inOrderTraversal() {
        return bst.inOrderTraversal();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam int value) {
        bst.delete(value);
        return "Deleted " + value;
    }

    @GetMapping("/preorder")
    public List<Integer> preOrderTraversal() {
        return bst.preOrderTraversal();
    }

    @GetMapping("/postorder")
    public List<Integer> postOrderTraversal() {
        return bst.postOrderTraversal();
    }

    @GetMapping("/levelorder")
    public List<Integer> levelOrderTraversal() {
        return bst.levelOrderTraversal();
    }

    @GetMapping("/height")
    public int getHeight() {
        return bst.getHeight();
    }

    @GetMapping("/is-balanced")
    public boolean isBalanced() {
        return bst.isBalanced();
    }

    // ✅ Uses shared bst instance to persist tree state
    @PostMapping("/process-numbers")
    public TreeStorage processNumbers(@RequestBody String rawInput) throws JsonProcessingException {
        List<Integer> numbers = parseInput(rawInput);

        numbers.forEach(bst::insert); // ✅ No shadowing — uses class-level bst

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

    // ✅ Flexible input parser: handles JSON, comma-separated, or space-separated formats
    private List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            numbers = mapper.readValue(input, mapper.getTypeFactory().constructCollectionType(List.class, Integer.class));
            return numbers;
        } catch (Exception ignored) {}

        input = input.replace("[", "")
                .replace("]", "")
                .replace("(", "")
                .replace(")", "")
                .replace("{", "")
                .replace("}", "");

        String[] parts = input.split(",|\\s+");

        for (String part : parts) {
            try {
                numbers.add(Integer.parseInt(part.trim()));
            } catch (NumberFormatException ignored) {}
        }

        return numbers;
    }
}
