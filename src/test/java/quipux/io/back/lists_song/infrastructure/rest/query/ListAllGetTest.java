package quipux.io.back.lists_song.infrastructure.rest.query;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import quipux.io.back.lists_song.application.ListAllService;
import quipux.io.back.lists_song.domain.ListSong;
import quipux.io.back.lists_song.domain.ListSongRepository;

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
        final var expectedPayload = new ArrayList<ListSong>();

        final ListSongRepository repository = mock(ListSongRepository.class);
        when(repository.getAllListSong()).thenReturn(expectedPayload);

        ListAllService service = new ListAllService(repository);
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
        final List<ListSong> expectedPayload = ListSongMother.createListOfSong();
        final Integer expectCountElementInList = expectedPayload.size();

        final ListSongRepository repository = mock(ListSongRepository.class);
        when(repository.getAllListSong()).thenReturn(expectedPayload);

        ListAllService service = new ListAllService(repository);
        ListAllGet controller = new ListAllGet(service);

        //when
        final var currentResult = controller.listAll();

        //then
        assertThat(expectedHttpStatus , equalTo(currentResult.getStatusCode()));
        assertThat(expectedPayload, equalTo(currentResult.getBody()));
        assertThat(expectCountElementInList, equalTo(currentResult.getBody().size()));
    }
}