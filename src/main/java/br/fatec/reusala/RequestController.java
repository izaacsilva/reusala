package br.fatec.reusala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/request")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @PostMapping(path = "/save")
    public @ResponseBody Request saveRequest(Request request) {
        return requestRepository.save(request);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @PostMapping(path="/delete")
    public @ResponseBody String deleteRequest(@RequestParam Integer id) {
        try {
            requestRepository.deleteById(id);
            return String.format("Request id %d deleted!", id);
        } catch (EmptyResultDataAccessException e) {
            return String.format("Request with id %d doesn't exist!", id);
        }
    }
}
