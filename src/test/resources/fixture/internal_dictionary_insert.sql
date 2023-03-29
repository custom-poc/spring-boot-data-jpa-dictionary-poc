insert into internal_dictionary(id, relation_id, priority, code, caption, description, discriminator)
values ('303c22a6-403d-49f1-84f6-fd3290f80cad', null,
        1, 'code-1', 'ProviderAppealReasonCaption-1', 'Description-1', 'provider-appeal-reason'),
       ('acae1541-19f8-4811-ad26-52cef148dfab', null,
        2, 'code-2', 'ProviderAppealReasonCaption-2', 'Description-2', 'provider-appeal-reason'),
        /* Violation */
       ('46d346aa-9290-4a1b-81dc-171e55319eef', '303c22a6-403d-49f1-84f6-fd3290f80cad',
        1, 'code-1', 'RegistrationViolationCaption-1', 'Description-1', 'provider-appeal-violation-reason'),
       ('7b8d6333-35ad-4384-a97f-914973805438', '303c22a6-403d-49f1-84f6-fd3290f80cad',
        2, 'code-2', 'RegistrationViolationCaption-2', 'Description-2', 'provider-appeal-violation-reason'),
        /* Rejection */
       ('2ffb0c1a-4c65-4200-87f1-c39802f7f79e', '303c22a6-403d-49f1-84f6-fd3290f80cad',
        1, 'code-1', 'RegistrationRejectionCaption-1', 'Description-1', 'provider-appeal-rejection-reason'),
       ('bf9a788c-d6a8-47e7-8fb1-e7c7fedb0e4f', '303c22a6-403d-49f1-84f6-fd3290f80cad',
        2, 'code-2', 'RegistrationRejectionCaption-2', 'Description-2', 'provider-appeal-rejection-reason');
