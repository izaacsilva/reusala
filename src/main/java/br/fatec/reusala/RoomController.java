package br.fatec.reusala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/room")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @PostMapping(path = "/save")
    public @ResponseBody Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @PostMapping(path="/delete")
    public @ResponseBody String deleteRoom(@RequestParam Integer id) {
        try {
            roomRepository.deleteById(id);
            return String.format("Room id %d deleted!", id);
        } catch (EmptyResultDataAccessException e) {
            return String.format("Room with id %d doesn't exist!", id);
        }
    }
}
