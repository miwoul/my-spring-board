package org.kitri.myspringboard.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.kitri.myspringboard.domain.Board;
import org.kitri.myspringboard.sevice.BoardService;
import org.kitri.myspringboard.sevice.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "list";
    }
    @GetMapping("/{id}")
    public String list(@PathVariable Long id, Model model) {
        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        return "view";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("board", new Board());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Board board) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        board.setWriter(username);
        boardService.save(board);
        return "redirect:/board/list";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "edit";
    }
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id, @ModelAttribute Board board) {
        board.setId(id);
        boardService.update(board);
        return "redirect:/board/list";
    }
    @PostMapping("/{id}/delete")
    public String deleteComment(@PathVariable long id,
                                @RequestParam long boardId) {
        commentService.deleteComment(id);
        return "redirect:/board/" + boardId;
    }
}
