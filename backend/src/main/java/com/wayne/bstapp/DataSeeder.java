package com.wayne.bstapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wayne.bstapp.model.TreeStorage;
import com.wayne.bstapp.repository.TreeRepository;
import com.wayne.bstapp.service.BinarySearchTree;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final TreeRepository treeRepository;

    public DataSeeder(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("🚀 DataSeeder is running...");

        if (treeRepository.count() == 0) {
            ObjectMapper mapper = new ObjectMapper();

            List<List<Integer>> sampleSets = List.of(
                    List.of(10, 5, 15),
                    List.of(20, 10, 30, 5, 15),
                    List.of(3, 1, 4, 2),
                    List.of(50, 30, 70, 20, 40, 60, 80),
                    List.of(8, 3, 10, 1, 6, 14, 4, 7, 13)
            );

            for (List<Integer> numbers : sampleSets) {
                try {
                    BinarySearchTree bst = new BinarySearchTree();
                    numbers.forEach(bst::insert);

                    String treeJson = mapper.writeValueAsString(bst.getRoot());

                    TreeStorage tree = new TreeStorage(numbers.toString(), treeJson);
                    treeRepository.save(tree);

                    System.out.println("🌱 Seeded TreeStorage with: " + numbers);
                } catch (JsonProcessingException e) {
                    System.err.println("❌ Failed to serialize tree for: " + numbers);
                    e.printStackTrace();
                }
            }

            System.out.println("✅ Finished seeding multiple trees.");
        } else {
            System.out.println("🌳 TreeStorage already has data.");
        }
    }
}
