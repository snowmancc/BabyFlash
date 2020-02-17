package com.snow.server5.controller;


import com.snow.server5.exception.http.NotFoundException;
import com.snow.server5.model.*;
import com.snow.server5.model.card.CardModelList;
import com.snow.server5.model.card.CardModelList2;
import com.snow.server5.model.card.NoteModel;
import com.snow.server5.model.member.MemberInfoModel;
import com.snow.server5.model.member.MemberModel;
import com.snow.server5.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.springframework.http.ResponseEntity.status;


@RestController
@RequestMapping("/edward")
public class EdwardController {

    @Autowired
    MemberService memberService;

    @Autowired
    KnowledgeCardService knowledgeCardService;

    @Autowired
    MemberFavoriteKnowledgeCardService memberFavoriteKnowledgeCardService;

    @Autowired
    MemberCardsService memberCardsService;

    @Autowired
    MemberFavoriteCardsService memberFavoriteCardsService;

    @Autowired
    ImageFileService imageFileService;

    //2
    @GetMapping(value = "/check/email", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ModelCarrier> checkEmail(@RequestParam String email) {

        if (memberService.checkEmailExists(email)) {
            return status(HttpStatus.CONFLICT).body(new MessageModel("Email is already registered"));
        } else {
            return status(HttpStatus.OK).body(new MessageModel("Email can be use"));
        }
    }

    //3
    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ModelCarrier> register(@RequestBody MemberModel member) {
        if (!memberService.checkEmailExists(member.getEmail())) {
            memberService.addMember(member);
            return status(HttpStatus.NO_CONTENT).build();
        } else {
            return status(HttpStatus.CONFLICT).body(new MessageModel("Email is already registered"));
        }
    }

    //1
    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ModelCarrier> login(@RequestBody CertificationModel certification) {
        String email = certification.getEmail();
        String password = certification.getPassword();
        if (memberService.checkEmailExists(email)) {
            if (memberService.checkCertification(email, password)) {
                String sToken = memberService.createToken(email, password);
                return status(HttpStatus.OK).body
                        (new TokenModel(sToken, memberService.getMemberId(email), memberService.getMemberImageUrl(email)));
            } else {
                return status(HttpStatus.NOT_FOUND).body(new MessageModel("Wrong password"));
            }
        } else {
            return status(HttpStatus.NOT_FOUND).body(new MessageModel("Email unregister"));
        }
    }

    //4
    @GetMapping(value = "/members/{member_id}/info", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ModelCarrier> getMemberInfo(@PathVariable("member_id") int memberId, @RequestHeader String token) {

        try {
            if (memberService.verifyToken(memberId, token)) {
                return status(HttpStatus.OK).body(memberService.getMemberInfo(String.valueOf(memberId)));
            } else {
                return status(HttpStatus.UNAUTHORIZED).body(new MessageModel("Wrong validation"));
            }
        } catch (NotFoundException e) {
            return status(HttpStatus.NOT_FOUND).body(new MessageModel(e.getMessage()));
        }
    }

    //5
    @PutMapping(value = "/members/{member_id}/info", produces = "application/json;charset=UTF-8") //解決回傳JSON格式
    public ResponseEntity<ModelCarrier> updateMemberInfo(@PathVariable("member_id") int memberId, @RequestHeader String token, @RequestBody MemberInfoModel memberInfo) {

        try {
            if (memberService.verifyToken(memberId, token)) {
                memberService.updateMemberInfo(String.valueOf(memberId), memberInfo);
                return status(HttpStatus.OK).build();
            } else {
                return status(HttpStatus.UNAUTHORIZED).body(new MessageModel("Wrong validation"));
            }
        } catch (NotFoundException e) {
            return status(HttpStatus.NOT_FOUND).body(new MessageModel(e.getMessage()));
        }
    }

    //    todo image load to im_gur do
    @PostMapping(value = "/members/{member_id}/image",consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ModelCarrier> loadMemberImage(@PathVariable("member_id") int memberId, @RequestHeader String token, @RequestParam("file") MultipartFile file) {
        if (memberService.verifyToken(memberId, token)) {
            String url = imageFileService.saveMemberImage(memberId, file);
            return status(HttpStatus.OK).body(new ImageUrlModel(url));
        }
        return status(HttpStatus.UNAUTHORIZED).body(new MessageModel("Wrong validation"));
    }

    @GetMapping(value = "/members/{member_id}/image", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ModelCarrier> getMemberImageUrl(@PathVariable("member_id") int memberId, @RequestHeader String token) {
        if (memberService.verifyToken(memberId, token)) {
            String url = imageFileService.loadMemberImage(memberId);
            return status(HttpStatus.OK).body(new ImageUrlModel(url));
        }
        return status(HttpStatus.UNAUTHORIZED).body(new MessageModel("Wrong validation"));
    }

    //6
    @GetMapping(value = "/cards", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ModelCarrier> getRandomCards(@RequestHeader String token, @RequestParam("card_pieces") String cardPiece) {
        if (memberService.verifyToken(token)) {
            return status(HttpStatus.OK).body(new CardModelList(knowledgeCardService.getRandomCards(Integer.valueOf(cardPiece))));
        }
        return status(HttpStatus.UNAUTHORIZED).body(new MessageModel("Wrong validation"));
    }

    //7
    @GetMapping(value = "/cards/tags", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ModelCarrier> getCardsByTag(@RequestHeader String token, @RequestParam String issueTags, @RequestParam String ageTag) {
        if (memberService.verifyToken(token)) {
            return status(HttpStatus.OK).body(new CardModelList(knowledgeCardService.getCardsByTag(ageTag, issueTags)));
        }
        return status(HttpStatus.UNAUTHORIZED).body(new MessageModel("Wrong validation"));
    }

    //8
    @PutMapping(value = "/members/{member_id}/cards/{card_id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ModelCarrier> memberFavoriteCards(@PathVariable("member_id") int memberId, @PathVariable("card_id") String cardId, @RequestHeader String token, @RequestBody NoteModel note) {
        if (memberService.verifyToken(memberId, token)) {
            memberFavoriteKnowledgeCardService
                    .recordMemberFavoriteKnowledge(String.valueOf(memberId), cardId, note.getNote());
            return status(HttpStatus.NO_CONTENT).build();
        }
        return status(HttpStatus.UNAUTHORIZED).body(new MessageModel("Wrong validation"));
    }

    //9
    @DeleteMapping(value = "/members/{member_id}/cards/{card_id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ModelCarrier> memberCancelFavoriteCards(@PathVariable("member_id") int memberId, @PathVariable("card_id") String cardId, @RequestHeader String token) {
        if (memberService.verifyToken(memberId, token)) {
            memberFavoriteKnowledgeCardService.cancelMemberFavoriteKnowledge(String.valueOf(memberId), cardId);
            return status(HttpStatus.NO_CONTENT).build();
        }
        return status(HttpStatus.UNAUTHORIZED).body(new MessageModel("Wrong validation"));
    }

    //10
    @GetMapping(value = "/members/{member_id}/cards", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ModelCarrier> memberFavoriteCards(@PathVariable("member_id") int memberId, @RequestHeader String token) {
        if (memberService.verifyToken(memberId, token)) {
            return status(HttpStatus.OK).body
                    (new CardModelList2
                            (memberFavoriteCardsService.getMemberCards(memberId)));
        }
        return status(HttpStatus.UNAUTHORIZED).body(new MessageModel("Wrong validation"));
    }

    //11
    @PostMapping(value = "/members/{member_id}/mycards", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ModelCarrier> createMemberCard(@PathVariable("member_id") int memberId,
                                                         @RequestHeader String token,
                                                         @RequestParam MultipartFile file,
                                                         @RequestParam String note
                                                         ){
        if(memberService.verifyToken(memberId, token)){
            memberCardsService.createCard(memberId, file, note);
            return status(HttpStatus.NO_CONTENT).build();
        }
        return status(HttpStatus.UNAUTHORIZED).body(new MessageModel("Wrong validation"));
    }

    @PutMapping(value = "/members/{member_id}/mycards/{mycard_id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ModelCarrier> addMemberCardNote(@PathVariable("member_id") int memberId,
                                                          @PathVariable("mycard_id") int myCardId,
                                                          @RequestBody NoteModel noteModel,
                                                          @RequestHeader String token
    ){
        if(memberService.verifyToken(memberId, token)){
            try {
                memberCardsService.addNote(myCardId, noteModel.getNote());
            }catch(NotFoundException e){
                return status(HttpStatus.UNAUTHORIZED).body(new MessageModel(e.getMessage()));
            }
            return status(HttpStatus.NO_CONTENT).build();
        }
        return status(HttpStatus.UNAUTHORIZED).body(new MessageModel("Wrong validation"));
    }

    //12
    @DeleteMapping(value = "/members/{member_id}/mycards/{mycard_id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ModelCarrier> cancelMemberCard(@PathVariable("member_id") int memberId,
                                                         @PathVariable("mycard_id") int cardId,
                                                         @RequestHeader String token){
        if(memberService.verifyToken(memberId, token)){
            memberCardsService.cancelMyCard(memberId, cardId);
            return status(HttpStatus.NO_CONTENT).build();
        }
        return status(HttpStatus.UNAUTHORIZED).body(new MessageModel("Wrong validation"));
    }
}
