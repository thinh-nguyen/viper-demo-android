package com.meltwater.viperdemo.documents;

import com.meltwater.viperdemo.documents.entity.DocumentModel;
import com.meltwater.viperdemo.documents.entity.DocumentUIModel;
import com.meltwater.viperdemo.documents.DataManager.DocServiceApi;

import java.util.HashMap;
import java.util.List;

/**
 * Created by thinhnguyen on 12/3/17.
 */

public interface DocumentListContract {

    interface View {

        /* NOTE that the component on the right must implement this protocol, in this case it's the activity */
        /* Presenter -> View */
        void showDocuments(List<DocumentUIModel> documentsUIModels);
    }

    interface Presenter {
        /* View -> Presenter */
        void presentDocuments(); //  Ask interactor to retrieve documents and tell view to show
    }

    interface InteractorInput {
       /* Presenter -> Interactor -- ask */
        void retrieveDocuments(HashMap<String, Object> query);
    }

    interface InteractorOutput {
        /* Interactor -> Presenter -- receive */
        void didRetrieveDocuments(List<DocumentModel> documentModels);
    }

    interface Router {

        // Don't need to create the first activity like in iOS?
        // void createDocumentViewController() -> UIViewController

        /* Presenter -> Router */
        void routeToDocumentScreen(DocumentUIModel documentUIModel);
    }

    interface DataManagerInput {

        /* Interator -> DataManager */
        void retrieveDocuments(HashMap<String, Object> query);
    }

    interface DataManagerOutput {
        /* DataManager -> Interactor */  /* Interactor must implement this protocol */
        void didRetrieveDocuments(List<DocumentModel> documents);
        void onError(String errorMsg);
    }
}
