package quipux.io.back.lists.infrastructure.rest.query;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import quipux.io.back.list.application.ListService;
import quipux.io.back.list.infrastructure.controller.query.ListAllGet;
import quipux.io.back.list.infrastructure.persistence.DataBaseH2ListSong;
import quipux.io.back.list.infrastructure.persistence.ListSongEntity;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ListAllGetTest {

    @Test
    void should_return_empty_lists_of_song_with_status_ok() {
        //given
        final var expectedHttpStatus = HttpStatus.OK;
        final var expectedPayload = new ArrayList<ListSongEntity>();

        final DataBaseH2ListSong repository = mock(DataBaseH2ListSong.class);
        when(repository.findAll()).thenReturn(expectedPayload);

        ListService service = new ListService(repository);
        ListAllGet controller = new ListAllGet(service);

        //when
        final var currentResult = controller.listAll();

        //then
        assertThat(expectedHttpStatus , equalTo(currentResult.getStatusCode()));
        assertThat(expectedPayload, equalTo(currentResult.getBody()));
    }

    @Test
    void should_return_list_of_song_with_status_ok() {
        //given
        final var expectedHttpStatus = HttpStatus.OK;
        final List<ListSongEntity> expectedPayload = ListSongMother.createListOfSong();
        final Integer expectCountElementInList = expectedPayload.size();

        final DataBaseH2ListSong repository = mock(DataBaseH2ListSong.class);
        when(repository.findAll()).thenReturn(expectedPayload);

        ListService service = new ListService(repository);
        ListAllGet controller = new ListAllGet(service);

        //when
        final var currentResult = controller.listAll();

        //then
        assertThat(expectedHttpStatus , equalTo(currentResult.getStatusCode()));
        assertThat(expectedPayload, equalTo(currentResult.getBody()));
        assertThat(expectCountElementInList, equalTo(currentResult.getBody().size()));
    }


}