Rails.application.routes.draw do
  devise_for :users
  resources :tasks

  root 'home#index'
end
