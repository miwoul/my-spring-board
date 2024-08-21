package org.kitri.myspringboard.controller;

import org.kitri.myspringboard.domain.Comment;
import org.kitri.myspringboard.sevice.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {
//    @Autowired
//    private CommentService commentService;
//        @PostMapping("/comment")
//        public String addComment(@RequestParam("boardId") Long boardId, @RequestParam("content") String content) {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            String username = ((UserDetails) authentication.getPrincipal()).getUsername();
//
//            Comment comment = new Comment();
//            comment.setBoardId(boardId);
//            comment.setContent(content);
//            comment.setUsername(username);
//            commentService.commentcreate(comment);
//
//            return "redirect:/board/" + boardId;
//        }

    @Autowired
    private CommentService commentService;
    @GetMapping("/")
    public String index() {
        return "main";
    }

    @PostMapping("/comment")
    public String addComment(@ModelAttribute Comment comment) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();

        comment.setUsername(username);
        commentService.commentCreate(comment);

        return "redirect:/board/" + comment.getBoardId(); // Redirect to the board detail page
    }

    @PostMapping("/comment/{id}")
    public String deleteComment(@PathVariable("id") Long commentId) {
        commentService.deleteComment(commentId);
        // 선택적으로 삭제 후 다른 페이지로 리다이렉트할 수 있습니다
        return "redirect:/board/list"; // 메인 페이지로 리다이렉트
    }

//    @PostMapping("/comment")
//    public String addComment(@RequestParam("comment") String comment) {
//        return "redirect:/views/comment";
//    }
//@Autowired
//private CommentService commentService;
//
//    @PostMapping("/comment")
//    public String addComment(@RequestParam("boardId") Long boardId,
//                             @RequestParam("content") String content) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
//
//        Comment comment = new Comment();
//        comment.setBoardId(boardId);
//        comment.setContent(content);
//        comment.setUsername(username);
//        commentService.createComment(comment);
//
//        return "redirect:/board/" + boardId;
//    }
}
