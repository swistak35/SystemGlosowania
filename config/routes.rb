Rails.application.routes.draw do
  devise_for :users

  resources :tasks do
    member do
      post 'mark'
      post 'unmark'
    end
  end

  root 'home#index'
end
