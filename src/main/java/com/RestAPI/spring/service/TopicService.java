package com.RestAPI.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.RestAPI.spring.controller.Topic;

@Service
public class TopicService {
	List<Topic> topicsList = new ArrayList<Topic>(Arrays.asList(new Topic("java", "Core Java", "Course for Core Java"),
			new Topic("Spring", "Spring boot", "Course for Spring boot"),
			new Topic("JavaScript", "Java Script Advanced", "Course for advanced JavaScript")));

	public List<Topic> getAllTopics() {
		return topicsList;

	}

	public Topic getTopic(String id) {
		return topicsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addNewTopic(Topic topic) {
		topicsList.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topicsList.size(); i++) {
			Topic t = topicsList.get(i);
			if (t.getId().equals(id)) {
				topicsList.set(i, topic);
				return;
			}
		}

	}

	public void deleteTopic(String id) {
		topicsList.removeIf(t->t.getId().equals(id));
	}

}
