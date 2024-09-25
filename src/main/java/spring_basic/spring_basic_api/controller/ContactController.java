package spring_basic.spring_basic_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring_basic.spring_basic_api.entity.User;
import spring_basic.spring_basic_api.request.contact.CreateContactRequest;
import spring_basic.spring_basic_api.request.contact.SearchContactRequest;
import spring_basic.spring_basic_api.request.contact.UpdateContactRequest;
import spring_basic.spring_basic_api.response.PagingResponse;
import spring_basic.spring_basic_api.response.WebResponse;
import spring_basic.spring_basic_api.response.contact.ContactResponse;
import spring_basic.spring_basic_api.service.ContactService;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping(
            path = "/api/contacts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> create(User user, @RequestBody CreateContactRequest request) {
        ContactResponse contactResponse = contactService.create(user, request);
        return WebResponse.<ContactResponse>builder().data(contactResponse).build();
    }

    @GetMapping(
            path = "/api/contacts/{contactId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> getByUserAndId(User user, @PathVariable("contactId") String contactId) {
        ContactResponse contact = contactService.getByUserAndId(user, contactId);
        return WebResponse.<ContactResponse>builder().data(contact).build();
    }

    @PutMapping(
            path = "/api/contacts/{contactId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> updateById(
            User user,
            @RequestBody UpdateContactRequest request,
            @PathVariable("contactId") String contactId
    ) {
        request.setId(contactId);
        ContactResponse contact = contactService.update(user, request);
        return WebResponse.<ContactResponse>builder().data(contact).build();
    }

    @DeleteMapping(
            path = "/api/contacts/{contactId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> deleteByUserAndId(User user, @PathVariable("contactId") String contactId) {
        contactService.deleteByUserAndId(user, contactId);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(
            path = "/api/contacts",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<ContactResponse>> search(
            User user,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size
    ) {
        SearchContactRequest request = SearchContactRequest.builder()
                .page(page)
                .size(size)
                .name(name)
                .email(email)
                .phone(phone)
                .build();

        Page<ContactResponse> contactResponses = contactService.search(user, request);
        return WebResponse.<List<ContactResponse>>builder()
                .data(contactResponses.getContent())
                .paging(
                        PagingResponse.builder()
                                .currentPage(contactResponses.getNumber())
                                .totalPages(contactResponses.getTotalPages())
                                .size(contactResponses.getSize())
                                .build()
                )
                .build();
    }
}
