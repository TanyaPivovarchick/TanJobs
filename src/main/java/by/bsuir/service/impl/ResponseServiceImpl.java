package by.bsuir.service.impl;

import by.bsuir.entity.JobVacancy;
import by.bsuir.entity.Response;
import by.bsuir.repository.ResponseRepository;
import by.bsuir.service.ResponseService;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {

    private final ResponseRepository responseRepository;

    @Autowired
    public ResponseServiceImpl(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @Override
    public List<Response> getAllResponcies(Long userId) {
        Iterator<Response> responseIterator = responseRepository.findAllByUserId(userId).iterator();
        return IteratorUtils.toList(responseIterator);
    }
}
