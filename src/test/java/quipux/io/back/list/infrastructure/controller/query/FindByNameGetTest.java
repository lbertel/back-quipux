package quipux.io.back.list.infrastructure.controller.query;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import quipux.io.back.list.infrastructure.persistence.ListSongEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameGetTest {

    @Test
    void should_return_404_status_when_not_exist_list_name() {
        //given
        final var expectedHttpStatus = HttpStatus.NOT_FOUND;
        FindByNameGet controller = mock(FindByNameGet.class);
        when(controller.findBy(anyString())).thenReturn(ResponseEntity.notFound().build());

        //when
        final var currentResponse = controller.findBy("some list name");

        //then
        assertEquals(expectedHttpStatus, currentResponse.getStatusCode());
    }

    @Test
    void should_return_status_ok_when_exist_list_name() {
        //given
        final var expectedHttpStatus = HttpStatus.OK;

        FindByNameGet controller = mock(FindByNameGet.class);
        when(controller.findBy(anyString())).thenReturn(ResponseEntity.ok(new ListSongEntity()));

        //when
        final var currentResponse = controller.findBy("some list name");

        //then
        assertEquals(expectedHttpStatus, currentResponse.getStatusCode());
        assertNotNull(currentResponse.getBody());
    }

    @Test
    void should_return_status_bad_request_when_list_name_is_null() {
        //given
        final var expectedHttpStatus = HttpStatus.BAD_REQUEST;

        FindByNameGet controller = new FindByNameGet();

        //when
        final var currentResponse = controller.findBy(null);

        //then
        assertEquals(expectedHttpStatus, currentResponse.getStatusCode());
    }

    @Test
    void should_return_status_bad_request_when_list_name_is_empty() {
        //given
        final var expectedHttpStatus = HttpStatus.BAD_REQUEST;

        FindByNameGet controller = new FindByNameGet();

        //when
        final var currentResponse = controller.findBy("  ");

        //then
        assertEquals(expectedHttpStatus, currentResponse.getStatusCode());
    }
}